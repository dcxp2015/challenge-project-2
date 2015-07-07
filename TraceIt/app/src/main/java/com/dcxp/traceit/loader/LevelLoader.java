package com.dcxp.traceit.loader;

import android.content.Context;
import android.util.Log;

import com.dcxp.traceit.Level;
import com.dcxp.traceit.Utils;
import com.dcxp.traceit.Vertex;

import org.json.JSONArray;

import org.json.*;

/**
 * Created by Daniel on 7/6/2015.
 */
public class LevelLoader {
    public static final String TAG = "com.dcxp.traceit.loader";

    public static Level load(Context context, String level) {
        Vertex[] vertices = null;
        int[][] edges = null;

        try {
            JSONObject json = new JSONObject(Utils.fullyReadInputStream(context.getAssets().open(level)));
            JSONArray vertexArray = json.getJSONArray("vertices");
            JSONArray edgeMatrix = json.getJSONArray("edges");

            vertices = parseVertexArray(vertexArray);
            edges = parseEdgeMatrix(edgeMatrix, vertexArray.length());
        } catch(Exception e) {
            Log.e(TAG, e.toString());
        }

        return new Level(vertices, edges);
    }

    private static Vertex[] parseVertexArray(JSONArray jsonArray) {
        int length = jsonArray.length();
        Vertex[] vertices = new Vertex[length];

        try {
            for (int i = 0; i < length; i++) {
                JSONObject vertex = jsonArray.getJSONObject(i);

                vertices[i] = new Vertex((float) vertex.getDouble("x"), (float) vertex.getDouble("y"));
            }
        } catch(Exception e) {
            Log.e(TAG, e.toString());
        }

        return vertices;
    }

    private static int[][] parseEdgeMatrix(JSONArray edgeMatrix, int vertexCount) {
        int rows = edgeMatrix.length();
        int[][] matrix;

        matrix = new int[rows][vertexCount];

        try {
            for (int i = 0; i < rows; i++) {
                JSONArray row = edgeMatrix.getJSONArray(i);

                int[] data = new int[vertexCount];
                for (int j = 0; j < vertexCount; j++) {
                    data[j] = row.getInt(j);
                }

                matrix[i] = data;
            }
        } catch(Exception e) {
            Log.e(TAG, e.toString());
        }

        return matrix;
    }

}
