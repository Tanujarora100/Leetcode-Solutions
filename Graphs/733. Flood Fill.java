public class floodFillAlgorithm {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color)
            return image;
        int initialColor = image[sr][sc];
        return dfs(image, sr, sc, color, initialColor);
    }

    private int[][] dfs(int[][] image, int i, int j, int color, int initialColor) {
        if (i < 0 || j < 0 || i >= image.length || j >= image[0].length)
            return image;
        if (image[i][j] != initialColor)
            return image; // Same Elements check
        image[i][j] = color; // Filling New Color inplace of Old Color.
        dfs(image, i - 1, j, color, initialColor);
        dfs(image, i, j - 1, color, initialColor);
        dfs(image, i + 1, j, color, initialColor);
        dfs(image, i, j + 1, color, initialColor);

        return image;
    }
