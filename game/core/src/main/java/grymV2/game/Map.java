package grymV2.game;

import grymV2.game.config.MapSizes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import grymV2.game.grid.Grid;

class MapException extends Exception {
    private static final long serialVersionUID = 0l;
    public MapException(String s) {
        super(s);
    }
}

/**
 * Map
 */
public class Map {

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
        } catch (MapException | FileNotFoundException e) {
            throw e;
        }

        return grid;
    }

    //private static Grid mapToGrid(Grid grid, ArrayList<ArrayList<String[]>> map) {
    //}

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
