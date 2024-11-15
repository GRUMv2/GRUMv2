package grymV2.game;

import grymV2.game.config.MapSizes;
import grymV2.game.config.TextureMap;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import grymV2.game.grid.Grid;
import grymV2.game.grid.GridLayers;
import grymV2.game.world.BackgroundGameObject;
import grymV2.game.world.ForegroundGameObject;
import grymV2.game.world.Lake;
import grymV2.game.world.River;
import grymV2.game.world.Road;
import grymV2.game.world.Terrain;

/**
 * Map
 */
public class Map {

    public static class MapException extends Exception {
        private static final long serialVersionUID = 0l;
        public MapException(String s) {
            super(s);
        }
    }

    public static Grid genMap(MapSizes size) throws FileNotFoundException, MapException {
        Grid grid = new Grid(MapSizes.LARGE);
        // Not implemented - hardcoded map supplied
        grid = hardcodedMap(grid);
        return grid;
    }


    private static Grid hardcodedMap(Grid grid) throws MapException, FileNotFoundException {
        ArrayList<ArrayList<String[]>> map;
        try {
            map = loadMapFile("Map.txt");
            validateMapSize(grid, map);
            grid = mapToGrid(grid, map);
        } catch (MapException | FileNotFoundException e) {
            throw e;
        }

        return grid;
    }

    private static Grid mapToGrid(Grid grid, ArrayList<ArrayList<String[]>> map) throws MapException {
        ForegroundGameObject f;
        BackgroundGameObject b;
        for (byte i = 0; i < grid.getDimensionX(); i++) {
            for (byte j = 0; j < grid.getDimensionY(); j++) {
                switch (map.get(i).get(j)[0]) {
                    case "T":
                        b = new Terrain(TextureMap.TERRAIN);
                        break;
                    case "L":
                        b = new Lake(TextureMap.LAKE);
                        break;
                    case "R":
                        b = new River(TextureMap.RIVER_STRAIGHT);
                        break;
                    default:
                        throw new MapException("Invalid map (context: Background tile '" + map.get(i).get(j)[0] + "')");
                }
                grid.getTile(i, j).setLayer(GridLayers.BACKGROUND, b);

                switch (map.get(i).get(j)[1]) {
                    case "R":
                        f = new Road(TextureMap.ROAD_STRAIGHT);
                        break;
                    case "E": // Empty foreground
                        continue;
                    default:
                        throw new MapException("Invalid map (context: Foreground tile '" + map.get(i).get(j)[1] + "')");
                }
                grid.getTile(i, j).setLayer(GridLayers.FOREGROUND, f);
            }
        }
        return grid;
    }

    private static void validateMapSize(Grid grid, ArrayList<ArrayList<String[]>> map) throws MapException {
        if (map.size() > grid.getDimensionX() || map.get(0).size() > grid.getDimensionY()) {
            System.out.println(map.size());
            System.out.println(map.get(0).size());
            System.out.println(grid.getDimensionX());
            System.out.println(grid.getDimensionY());
            throw new MapException("Map too large");
        }
    }

    public static ArrayList<ArrayList<String[]>> loadMapFile(String filename) throws FileNotFoundException, MapException {
        File mapFile = new File(filename);
        if (! mapFile.exists()) {
            throw new FileNotFoundException("Map file not found");
        }

        ArrayList<ArrayList<String[]>> invertedMap = new ArrayList<ArrayList<String[]>>();
        ArrayList<ArrayList<String[]>> map = new ArrayList<ArrayList<String[]>>();
        Scanner s = new Scanner(mapFile);
        while (s.hasNextLine()) {
            String line = s.nextLine().strip();
            if (line.length() == 0 || line.charAt(0) == '#') {
                continue;
            }
            ArrayList<String[]> lineArray = new ArrayList<String[]>();
            for (String tile : line.split(" ")) {
                tile = tile.strip();
                if (tile.length() > 2) {
                    s.close();
                    throw new MapException("Invalid map (context: '" + tile + "')");
                }
                String[] tileArray = tile.split("");
                lineArray.add(tileArray);
            }
            invertedMap.add(lineArray);
            if (invertedMap.get(0).size() != lineArray.size()) {
                s.close();
                throw new MapException("Non-uniform map size");
            }
        }
        s.close();

        // flip xy
        int il = invertedMap.get(0).size();
        int jl = invertedMap.size();
        for (int i = 0; i < il; i++) {
            ArrayList<String[]> y = new ArrayList<String[]>();
            map.add(y);
            for (int j = 0; j < jl; j++) {
                map.get(i).add(invertedMap.get(j).get(i));
            }
        }

        return map;
    }
}
