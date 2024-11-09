package grymV2.game.client.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;

import grymV2.game.client.Cain;

public class GlobalInputListener {

    private final InputMultiplexer multiplexer;
    private PointerProcessor globalPointerProcessor;
    private PointerProcessor screenPointerProcessor;
    private KeyProcessor globalKeyProcessor;
    private KeyProcessor screenKeyProcessor;
    private AbstractInputHandler globalHandler;
    private AbstractInputHandler handler;

    public GlobalInputListener(Cain manager) {
        this.globalHandler = new GlobalInputHandler(manager);
        this.handler = new NullInputHandler();
        this.multiplexer = new InputMultiplexer();
        this.globalPointerProcessor = new PointerProcessor(this.globalHandler);
        this.globalKeyProcessor = new KeyProcessor(this.globalHandler);
        this.screenPointerProcessor = new PointerProcessor(this.handler);
        this.screenKeyProcessor = new KeyProcessor(this.handler);
        this.multiplexer.addProcessor(0, globalPointerProcessor);
        this.multiplexer.addProcessor(1, globalKeyProcessor);
        this.multiplexer.addProcessor(2, screenPointerProcessor);
        this.multiplexer.addProcessor(3, screenKeyProcessor);
        Gdx.input.setInputProcessor(this.multiplexer);
    }

    public void setHandler(AbstractInputHandler handler) {
        this.handler = handler;
        this.screenKeyProcessor.setHandler(handler);
        this.screenPointerProcessor.setHandler(handler);
    }

    public AbstractInputHandler getHandler() {
        return handler;
    }

    public void handle() {
        this.globalHandler.handle();
        this.handler.handle();
    }
}
