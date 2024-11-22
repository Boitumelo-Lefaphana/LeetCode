#include <vector>
#include <unordered_map>
using namespace std;

class Solution {
public:
    int maxEqualRowsAfterFlips(vector<vector<int>>& matrix) {
        unordered_map<string, int> patternCount;
        int maxRows = 0;

        for (const auto& row : matrix) {
            string pattern = "";
            string complementPattern = "";

            for (int val : row) {
                pattern += (val == 0) ? '0' : '1';
                complementPattern += (val == 0) ? '1' : '0';
            }

            // Increment counts for both the pattern and its complement
            maxRows = max(maxRows, ++patternCount[pattern]);
            maxRows = max(maxRows, ++patternCount[complementPattern]);
        }

        return maxRows;
    }
};
