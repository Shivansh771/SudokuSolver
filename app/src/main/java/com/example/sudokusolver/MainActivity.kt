package com.example.sudokusolver
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import com.example.sudokusolver.databinding.ActivityMainBinding
import com.google.android.material.textfield.TextInputEditText
import www.sanju.motiontoast.MotionToast
import www.sanju.motiontoast.MotionToastStyle

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val matrix: Array<Array<Int>> = Array(9) { Array(9) { 0 } }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnSolve.setOnClickListener{
            for(i in 0 until 9){
                for(j in 0 until 9){


                    val inputView = findViewById<TextInputEditText>(
                        resources.getIdentifier("input_$i$j", "id", packageName)
                    )
                    val value = inputView.text.toString().toIntOrNull() ?: 0
                    matrix[i][j] = value


                }
            }
            if(solveSudoku(matrix,9)){

                MotionToast.createColorToast(this,
                    "Solved️",
                    "The Sudoku was Solved",
                    MotionToastStyle.SUCCESS,
                    MotionToast.GRAVITY_BOTTOM,
                    MotionToast.LONG_DURATION,
                    ResourcesCompat.getFont(this,R.font.helvetica_regular))
                for (row in matrix) {
                    Log.d("MATRIX", row.joinToString())
                }
                binding.input00.setText(matrix[0][0].toString())
                binding.input01.setText(matrix[0][1].toString())
                binding.input02.setText(matrix[0][2].toString())
                binding.input03.setText(matrix[0][3].toString())
                binding.input04.setText(matrix[0][4].toString())
                binding.input05.setText(matrix[0][5].toString())
                binding.input06.setText(matrix[0][6].toString())
                binding.input07.setText(matrix[0][7].toString())
                binding.input08.setText(matrix[0][8].toString())


                binding.input10.setText(matrix[1][0].toString())
                binding.input11.setText(matrix[1][1].toString())
                binding.input12.setText(matrix[1][2].toString())
                binding.input13.setText(matrix[1][3].toString())
                binding.input14.setText(matrix[1][4].toString())
                binding.input15.setText(matrix[1][5].toString())
                binding.input16.setText(matrix[1][6].toString())
                binding.input17.setText(matrix[1][7].toString())
                binding.input18.setText(matrix[1][8].toString())

                binding.input20.setText(matrix[2][0].toString())
                binding.input21.setText(matrix[2][1].toString())
                binding.input22.setText(matrix[2][2].toString())
                binding.input23.setText(matrix[2][3].toString())
                binding.input24.setText(matrix[2][4].toString())
                binding.input25.setText(matrix[2][5].toString())
                binding.input26.setText(matrix[2][6].toString())
                binding.input27.setText(matrix[2][7].toString())
                binding.input28.setText(matrix[2][8].toString())

                binding.input30.setText(matrix[3][0].toString())
                binding.input31.setText(matrix[3][1].toString())
                binding.input32.setText(matrix[3][2].toString())
                binding.input33.setText(matrix[3][3].toString())
                binding.input34.setText(matrix[3][4].toString())
                binding.input35.setText(matrix[3][5].toString())
                binding.input36.setText(matrix[3][6].toString())
                binding.input37.setText(matrix[3][7].toString())
                binding.input38.setText(matrix[3][8].toString())

                binding.input40.setText(matrix[4][0].toString())
                binding.input41.setText(matrix[4][1].toString())
                binding.input42.setText(matrix[4][2].toString())
                binding.input43.setText(matrix[4][3].toString())
                binding.input44.setText(matrix[4][4].toString())
                binding.input45.setText(matrix[4][5].toString())
                binding.input46.setText(matrix[4][6].toString())
                binding.input47.setText(matrix[4][7].toString())
                binding.input48.setText(matrix[4][8].toString())

                binding.input50.setText(matrix[5][0].toString())
                binding.input51.setText(matrix[5][1].toString())
                binding.input52.setText(matrix[5][2].toString())
                binding.input53.setText(matrix[5][3].toString())
                binding.input54.setText(matrix[5][4].toString())
                binding.input55.setText(matrix[5][5].toString())
                binding.input56.setText(matrix[5][6].toString())
                binding.input57.setText(matrix[5][7].toString())
                binding.input58.setText(matrix[5][8].toString())

                binding.input60.setText(matrix[6][0].toString())
                binding.input61.setText(matrix[6][1].toString())
                binding.input62.setText(matrix[6][2].toString())
                binding.input63.setText(matrix[6][3].toString())
                binding.input64.setText(matrix[6][4].toString())
                binding.input65.setText(matrix[6][5].toString())
                binding.input66.setText(matrix[6][6].toString())
                binding.input67.setText(matrix[6][7].toString())
                binding.input68.setText(matrix[6][8].toString())

                binding.input70.setText(matrix[7][0].toString())
                binding.input71.setText(matrix[7][1].toString())
                binding.input72.setText(matrix[7][2].toString())
                binding.input73.setText(matrix[7][3].toString())
                binding.input74.setText(matrix[7][4].toString())
                binding.input75.setText(matrix[7][5].toString())
                binding.input76.setText(matrix[7][6].toString())
                binding.input77.setText(matrix[7][7].toString())
                binding.input78.setText(matrix[7][8].toString())

                binding.input80.setText(matrix[8][0].toString())
                binding.input81.setText(matrix[8][1].toString())
                binding.input82.setText(matrix[8][2].toString())
                binding.input83.setText(matrix[8][3].toString())
                binding.input84.setText(matrix[8][4].toString())
                binding.input85.setText(matrix[8][5].toString())
                binding.input86.setText(matrix[8][6].toString())
                binding.input87.setText(matrix[8][7].toString())
                binding.input88.setText(matrix[8][8].toString())

            }
            else{for (row in matrix) {
                Log.d("MATRIX", row.joinToString())
            }

                MotionToast.createColorToast(this,
                    "Failed ☹️",
                    "Could'nt solve The Sudoku",
                    MotionToastStyle.ERROR,
                    MotionToast.GRAVITY_BOTTOM,
                    MotionToast.LONG_DURATION,
                    ResourcesCompat.getFont(this,R.font.helvetica_regular))


            }


        }
    }

    fun isSafe(
        board: Array<Array<Int>>,
        row: Int, col: Int,
        num: Int
    ): Boolean {
        // Row has the unique (row-clash)
        for (d in board.indices) {

            // Check if the number we are trying to
            // place is already present in
            // that row, return false;
            if (board[row][d] == num) {
                return false
            }
        }

        // Column has the unique numbers (column-clash)
        for (r in board.indices) {

            // Check if the number
            // we are trying to
            // place is already present in
            // that column, return false;
            if (board[r][col] == num) {
                return false
            }
        }

        // Corresponding square has
        // unique number (box-clash)
        val sqrt = Math.sqrt(board.size.toDouble()).toInt()
        val boxRowStart = row - row % sqrt
        val boxColStart = col - col % sqrt
        for (r in boxRowStart until boxRowStart + sqrt) {
            for (d in boxColStart until boxColStart + sqrt) {
                if (board[r][d] == num) {
                    return false
                }
            }
        }

        // if there is no clash, it's safe
        return true
    }

    fun solveSudoku(
        board: Array<Array<Int>>, n: Int
    ): Boolean {
        var row = -1
        var col = -1
        var isEmpty = true
        for (i in 0 until n) {
            for (j in 0 until n) {
                if (board[i][j] == 0) {
                    row = i
                    col = j

                    // We still have some remaining
                    // missing values in Sudoku
                    isEmpty = false
                    break
                }
            }
            if (!isEmpty) {
                break
            }
        }

        // No empty space left
        if (isEmpty) {
            return true
        }

        // Else for each-row backtrack
        for (num in 1..n) {
            if (isSafe(board, row, col, num)) {
                board[row][col] = num
                if (solveSudoku(board, n)) {
                    // print(board, n);
                    return true
                } else {
                    // replace it
                    board[row][col] = 0
                }
            }
        }
        return false
    }
}