package main.map;

import main.functions.NoiseGenerator;
import main.tile.Beach;
import main.tile.Ocean;
import main.tile.Forest;
import main.tile.Tile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Map {
    NoiseGenerator noiseGenerator = new NoiseGenerator(0); //seed 5231 was used before
    private final HashMap<List<Integer>, Tile> map = new HashMap<List<Integer>, Tile>();

    public Tile getTileAtLocation(int x, int y){
        //check if location exists, if so return, else create then return
        List<Integer> xy = new ArrayList<>();
        xy.add(x);
        xy.add(y);
        if (!this.map.containsKey(xy)) {
            double noiseVal = noiseGenerator.noise((double) x, (double) y) + 0.5;
            if (noiseVal <= 0.5) {
                //forest
                this.map.put(xy, new Forest(x, y));
            } else if (noiseVal <= 0.6) {
                //beach
                this.map.put(xy, new Beach(x, y));
            } else {
                //ocean
                this.map.put(xy, new Ocean(x,y));
            }
        }
        return this.map.get(xy);
    }
    public void setTileAtLocation(int x, int y, Tile tile){
        List<Integer> xy = new ArrayList<>();
        xy.add(x);
        xy.add(y);
        if (this.map.containsKey(xy)){
            this.map.replace(xy, tile);
        }else{
            this.map.put(xy,tile);
        }
    }
}
