boolean sudoku2(char[][] grid) {
    final int n = 9;
    final int m = 3;
    boolean result = true;

    boolean[] existList = new boolean[10];

    for (int i = 0; i < n; i++) {
        Arrays.fill(existList, false);
        for (int j = 0; j < n; j++) {
            int val = Character.getNumericValue(grid[i][j]);
            if (val == -1) {
                continue;
            } else if (existList[val] == false) {
                existList[val] = true;
            } else {
                result = false;
                break;
            }
        }

        if (!result) {
            break;
        }
    }

    for (int j = 0; j < n; j++) {
        Arrays.fill(existList, false);
        for (int i = 0; i < n; i++) {
            int val = Character.getNumericValue(grid[i][j]);
            if (val == -1) {
                continue;
            } else if (existList[val] == false) {
                existList[val] = true;
            } else {
                result = false;
                break;
            }
        }

        if (!result) {
            break;
        }
    }

    for(int i = 0; i < m; i++) {
        for (int j = 0; j < m; j++) {
            Arrays.fill(existList, false);

            int startI = i * 3;
            int startJ = j * 3;

            for (int k = 0; k < m; k++) {
                for (int l = 0; l < m; l++) {
                    int val = Character.getNumericValue(grid[startI + k][startJ + l]);

                    if (val == -1) {
                        continue;
                    } else if (existList[val] == false) {
                        existList[val] = true;
                    } else {
                        result = false;
                        break;
                    }
                }
            }
        }
    }

    return result;
}
