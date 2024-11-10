package grymV2.game.client;

// TODO s/GAM/Game/g

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import grymV2.game.client.ui.Layout;
import grymV2.game.client.ui.MenuShape;
import grymV2.game.client.ui.TextBox;
import grymV2.game.client.ui.TextButton;
import grymV2.game.GameLogger;
import grymV2.game.client.ui.ImageButton;
import grymV2.game.grid.Grid;


/**
 * Cain's Left Foot - Game
 */
public class CainsLeftFoot extends /* NOT AGS */ ScreenAdapter {
    //
    // It might be possible to, within one game screen render step,
    // delegate both UI and Game stages to a separate ScreenAdapter
    // and hotswap between them without losing the output of the previous.
    // i.e. strip ScreenUtils.clear() and the hardcoded viewport values
    // from AGS and make CLF create two sub-screens for UI and game.
    // I couldn't be bothered to try but if there were more multi-viewport
    // game screens the below is obviously not a scalable way of doing it.
    //

    final private int VIEWPORT_HEIGHT = 40;
    final private int GAME_VIEWPORT_WIDTH = 40;
    final private int UI_VIEWPORT_WIDTH;
    final private float UI_RATIO;
    final private float GAME_RATIO;

    final Cain manager;
    final Grid grid;

    private float delta;

    // These viewports are FitViewport purely because it was
    // the text yanked from AGS but the custom resize function
    // essentially renders (audiencelaughter.ogg) this irrelevant.
    // Better scalable solution -> create a custom Viewport
    // and override its scaling methods therein.

    final private OrthographicCamera masterCamera;

    final private FitViewport uiViewport;
    final private SpriteBatch uiBatch;
    final private BitmapFont uiFont;
    final private ShapeRenderer uiShapeRenderer;

    final private FitViewport gameViewport;
    final private SpriteBatch gameBatch;
    final private BitmapFont gameFont;
    final private ShapeRenderer gameShapeRenderer;


    private Layout<Layout<? extends MenuShape>> masterBox;
    private Layout<TextBox> stats;
    //private Layout<ImageButton> placeables; // TODO
    private Layout<TextButton> placeables; // XXX: PLACEHOLDER
    private Layout<TextBox> info;
    //private ArrayList<ImageButton> buttons; // TODO
    private ArrayList<TextButton> buttons; // XXX: PLACEHOLDER
    private TextBox statsBox;
    private TextBox infoBox;

    public CainsLeftFoot(Cain manager, Grid grid) {
        this.masterCamera = new OrthographicCamera();
        this.masterCamera.setToOrtho(false, 1920, 1080);
        this.manager = manager;
        this.grid = grid;

        this.UI_RATIO = manager.game.settings.getUIRatio();
        this.GAME_RATIO = 1 - this.UI_RATIO;
        this.UI_VIEWPORT_WIDTH = Math.round(this.GAME_VIEWPORT_WIDTH * (this.UI_RATIO / this.GAME_RATIO)); // For now

        this.uiViewport = new FitViewport(this.UI_VIEWPORT_WIDTH, this.VIEWPORT_HEIGHT, this.masterCamera);
        this.uiBatch = new SpriteBatch();
        this.uiShapeRenderer = new ShapeRenderer();
        this.uiFont =  new BitmapFont();
        this.uiFont.setUseIntegerPositions(false);
        this.uiFont.getData().setScale(this.uiViewport.getWorldHeight() / Gdx.graphics.getHeight());

        this.gameViewport = new FitViewport(this.GAME_VIEWPORT_WIDTH, this.VIEWPORT_HEIGHT, this.masterCamera);
        this.gameBatch = new SpriteBatch();
        this.gameFont = new BitmapFont();
        this.gameShapeRenderer = new ShapeRenderer();
        this.gameFont.setUseIntegerPositions(false);
        this.gameFont.getData().setScale(this.gameViewport.getWorldHeight() / Gdx.graphics.getHeight());

        this.delta = 0f;

        GameLogger.debug(CainsLeftFoot.class, "Main init");

        mkUI();
        GameLogger.debug(CainsLeftFoot.class, "UI init");
        mkGAM();
        GameLogger.debug(CainsLeftFoot.class, "GAM init");
    }

    private void mkGAM() {
        // TODO
    }

    private void mkUI() {
        Viewport viewport = this.uiViewport;
        this.masterBox = new Layout<Layout<? extends MenuShape>>(viewport);
        this.masterBox.centreLayout(viewport);
        this.stats = new Layout<TextBox>(viewport);
        this.info = new Layout<TextBox>(viewport);
        //this.placeables = new Layout<ImageButton>(viewport); TODO
        //ImageButton button;
        //for (get all enabled building types); do
        //    make ImageButton for building type
        //    put ImageButton into this.placeables
        //done

        /*
         * XXX: START PLACEHOLDER
         */
        this.placeables = new Layout<TextButton>(viewport);
        TextButton button;
        String[] fs = new String[]{ "AAAAAAAAA", "BBBBBBBBB", "CCCCCCCC", "Kenneth", "DDDDDDDD", "EEEEEEEEE", "FFFFFFFF", "GGGGGGGG", "hhhhhhhh", "i" };
        int nButton = fs.length;
        Vector2 layoutSize = howLongIsAPieceOfVector2(nButton);
        int pointer = -1;
        for (int i = 0; i < layoutSize.x; i++) {
            for (int j = 0; j < layoutSize.y; j++) {
                pointer++;
                // layoutSize is the ideal button layout dimension
                // Verify index exists in array in case there are less entries
                // than needed to fill the grid (probable)
                if (pointer >= nButton) {
                    break;
                }
                button = new TextButton(this.uiFont);
                button.setText(fs[pointer]);
                button.setTextColor(this.manager.game.settings.getUIForeground());
                if (j == 0) {
                    this.placeables.left(button);
                } else {
                    this.placeables.add(button);
                }
            }
        }
        /*
         *
         * XXX: END PLACEHOLDER
         *
         */

        this.statsBox = new TextBox(this.uiFont);
        this.statsBox.setText("These are some stats.\n\nMuch stats.\n\nMany number.\n\nWow."); // TODO
        this.stats.add(this.statsBox);

        infoBox = new TextBox(this.uiFont);
        infoBox.setText("Nothing selected");
        this.info.add(this.infoBox);
        this.masterBox.add(this.stats);
        this.masterBox.add(this.placeables);
        this.masterBox.add(this.info);
    }

    private Vector2 howLongIsAPieceOfVector2(int len) {
        float sq = (float) Math.ceil(Math.sqrt(len));
        float x = sq > 3 ? 3 : sq;
        Vector2 v = new Vector2(x, (float) Math.ceil(len / x));
        return v;
    }

    public float getDelta() {
        return delta;
    }

    public void render(float delta) {
        GameLogger.debug(CainsLeftFoot.class, "Ren");
        this.delta = delta;
        ScreenUtils.clear(this.manager.game.settings.getUIBackground());
        input();
        logic();
        draw();
    }

    public void input() {
        this.manager.handleInput();
    }

    public void logic() {
    }

    public void draw() {
        GameLogger.debug(CainsLeftFoot.class, "GAM");
        doGAM();
        GameLogger.debug(CainsLeftFoot.class, "UI");
        doUI();
    }

    private void doGAM() {
        this.gameViewport.apply(true);
        this.gameShapeRenderer.setProjectionMatrix(this.gameViewport.getCamera().combined);
        this.gameShapeRenderer.begin(ShapeType.Filled);
        this.gameShapeRenderer.rect(0, 0, this.gameViewport.getWorldWidth(), this.gameViewport.getWorldHeight());
        this.gameShapeRenderer.end();
    }
    private void doUI() {
        this.uiViewport.apply(true);
        this.masterBox.draw(this.uiShapeRenderer, this.uiBatch, this.uiViewport.getCamera());
    }

    @Override
    public void resize(int width, int height) {
        GameLogger.debug(CainsLeftFoot.class, "RESY");
        int endpoint = resizeViewport(this.uiViewport, this.UI_RATIO, 0, width, height);
        resizeViewport(this.gameViewport, this.GAME_RATIO, endpoint, width, height);
        this.uiViewport.apply(true);
        this.gameViewport.apply(true);
    }

    private int resizeViewport(Viewport viewport, float ratio, int start, int width, int height) {
        // Only FitViewport because of Scaling.fit
        Vector2 scaled = Scaling.fit.apply(viewport.getWorldWidth(), viewport.getWorldHeight(), width * ratio, height);
        int viewportWidth = Math.round(scaled.x);
        int viewportHeight = Math.round(scaled.y);
        viewport.setScreenBounds(start, (height - viewportHeight) / 2, viewportWidth, viewportHeight);
        return viewportWidth;
    }

    public void dispose() {
        this.uiBatch.dispose();
        this.uiShapeRenderer.dispose();
        this.uiFont.dispose();
        this.gameBatch.dispose();
        this.gameFont.dispose();
        this.gameShapeRenderer.dispose();
    }

    @Override
    public void pause() {
        this.manager.pause();
    }
}
