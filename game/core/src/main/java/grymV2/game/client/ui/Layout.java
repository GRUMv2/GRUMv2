package grymV2.game.client.ui;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 * Layout
 */
public class Layout<T extends UIElement> implements UIElement {

    private float x;
    private float y;
    private float width;
    private float height;

    private ArrayList<ArrayList<T>> shapes;
    private int li;
    private int lj;

    private enum Positions { ABOVE, BELOW, LEFT, RIGHT }

    public Layout(Viewport viewport) {
        this(viewport.getWorldWidth(), viewport.getWorldHeight());
    }

    public Layout(float width, float height) {
        this.shapes = new ArrayList<ArrayList<T>>();
        this.shapes.add(new ArrayList<T>());
        this.li = -1;
        this.lj = -1;
        this.x = 0;
        this.y = 0;
        this.width = width;
        this.height = height;
    }

    public ArrayList<ArrayList<T>> getShapes() {
        return shapes;
    }

    private void setDimensions() {
        int itemsX = this.shapes.size();
        float spaceX = (this.getWidth() * 0.1f) / (itemsX + 1);
        float itemWidth = (this.getWidth() * 0.9f) / itemsX;
        int jsize;
        int itemsY = 0;
        for (int i = 0; i < itemsX; i++) {
            jsize = this.shapes.get(i).size();
            if (jsize > itemsY) {
                itemsY = jsize;
            }
        }
        float spacingY = (this.getHeight() * 0.1f) / (itemsY + 1);
        float itemHeight = (this.getHeight() * 0.9f) / itemsY;
        float offsetX = this.getX() + spaceX;
        float offsetY = this.getY() + spacingY;
        T shape;
        for (int i = 0; i < itemsX; i++) {
            jsize = this.shapes.get(i).size();
            for (int j = 0; j < jsize; j++) {
                shape = this.shapes.get(i).get(j);
                if (shape != null) {
                    shape.setX(offsetX);
                    shape.setY(offsetY);
                    shape.setWidth(itemWidth);
                    shape.setHeight(itemHeight);
                }
                offsetY += itemHeight + spacingY;
            }
            offsetX += itemWidth + spaceX;
            offsetY = this.getY() + spacingY;
        }
    }

    public void draw(ShapeRenderer shapeRenderer, SpriteBatch batch, Camera camera) {
        setDimensions();
        for (int i = 0; i < shapes.size(); i++) {
            ArrayList<T> shapesColumn = shapes.get(i);
            for (int j = 0; j < shapesColumn.size(); j++) {
                T shape = shapesColumn.get(j);
                if (shape != null) {
                    shape.draw(shapeRenderer, batch, camera);
                }
            }
        }
        //System.exit(1);
    }

    private void put(T shape, Positions pos) {
        int i = this.li;
        int j = this.lj;
        switch (pos) {
            case BELOW: j--; break;
            case ABOVE: j++; break;
            case RIGHT: i++; break;
            case LEFT: i--; break;
            default: break;
        }
        if (i < 0) {
            if (this.shapes.get(0).size() > 0) {
                this.shapes.add(0, new ArrayList<T>());
            }
            i = 0;
        } else if (i > shapes.size()) {
            this.shapes.add(new ArrayList<T>());
        }
        int jsize = this.shapes.get(i).size();
        if (j < 1) {
            j = 0;
            if (jsize > 0 && this.shapes.get(i).get(j) == null) {
                this.shapes.get(i).set(j, shape);
            } else {
                this.shapes.get(i).add(j, shape);
            }
        } else if (jsize - 1 < j) {
            for (int n = jsize; n < j; n++) {
                this.shapes.get(i).add(n, null);
            }
            this.shapes.get(i).add(j, shape);
        } else {
            this.shapes.get(i).set(j, shape);
        }

        setDimensions();
        this.li = i;
        this.lj = j;
    }


    public void add(T shape) {
        put(shape, Positions.BELOW);
    }

    public void below(T shape) {
        put(shape, Positions.BELOW);
    }

    public void above(T shape) {
        put(shape, Positions.ABOVE);
    }

    public void right(T shape) {
        put(shape, Positions.RIGHT);
    }

    public void left(T shape) {
        put(shape, Positions.LEFT);
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public void centreLayout(Viewport viewport) {
        float hww = viewport.getWorldWidth() / 2;
        float hwh = viewport.getWorldHeight() / 2;
        centreLayout(hww, hwh);
    }

    public void centreLayout(float x, float y) {
        float htw = this.width / 2;
        float xmhtw = x - htw;
        this.setX(xmhtw > 0 ? xmhtw : 0);
        float hth = this.height / 2;
        float ymhth = y - hth;
        this.setY(ymhth > 0 ? ymhth : 0);
    }

}
