package grymV2.game.world;

import grymV2.game.config.TextureMap;

/**
 * LectureHall
 */
public class LectureHall extends Building {
    // TODO: I pulled 100 out of thin air
    // It should be some part of the actual object logic or serverside
    private final int capacity = 100;

    public LectureHall(TextureMap texture) {
        super(TextureMap.LECTUREHALL, "Lecture Hall", "A lecture theatre with capacity for 100 students.");
    }
}
