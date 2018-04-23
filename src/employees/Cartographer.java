package employees;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import dat.Block;
import dat.BlockGrid;
import dat.BlockType;

public class Cartographer {

	public static void saveMap(String mapID, BlockGrid grid) {
		String mapDat = "";
		for (int i = 0; i < grid.getBlocksWide(); i++) {
			for (int j = 0; j < grid.getBlocksHigh(); j++) {
				mapDat += getBlockID(grid.getBlock(i, j));
			}

		}
		File file = new File(mapID);
		try {
			BufferedWriter bufferWrite = new BufferedWriter(new FileWriter(file));
			bufferWrite.write(mapDat);
			bufferWrite.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static BlockGrid loadMap(String mapName) {
		BlockGrid grid = new BlockGrid();
		try {
			BufferedReader bufferRead = new BufferedReader(new FileReader(mapName));
			String data = bufferRead.readLine();
			for (int i = 0; i < grid.getBlocksWide(); i++) {
				for (int j = 0; j < grid.getBlocksHigh(); j++) {
					grid.setBlock(i, j, getBlockType(data.substring(i * grid.getBlocksHigh() + j, i * grid.getBlocksHigh() + j + 1)));
				}
			}
			bufferRead.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return grid;
	}
	
	// Turns a type of block into a string
	@SuppressWarnings("incomplete-switch")
	public static String getBlockID(Block b) {
		String ID = "Z";
		switch (b.getType()) {
		case Ground:
			ID = "0";
			break;
		case Road:
			ID = "1";
			break;
		case NULL:
			ID = "10";
			break;
		}
		return ID;
	}

	// The other way around of the above
	public static BlockType getBlockType(String ID) {
		BlockType type = BlockType.NULL;
		switch (ID) {
		case "0":
			type = BlockType.Ground;
			break;
		case "1":
			type = BlockType.Road;
			break;
		case "10":
			type = BlockType.NULL;
			break;
		}
		return type;
	}
}
