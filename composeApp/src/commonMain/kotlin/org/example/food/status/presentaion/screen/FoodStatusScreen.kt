package org.example.food.status.presentaion.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import org.example.food.status.presentaion.viewModel.FoodStatusViewModel

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun FoodStatusScreen(
    foodViewModel: FoodStatusViewModel = viewModel(factory = FoodStatusViewModel.Factory)
) {
    val uiState = foodViewModel.uiState.collectAsState()


    Row(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier.fillMaxHeight()
                .weight(0.6f)
                .background(Color(0xff5F5F5F))
                .padding(vertical = 30.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(
                    "Preparing جارى التحضير", style = TextStyle(
                        color = Color.White,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
                FlowRow(
                    modifier = Modifier.padding(vertical = 10.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    uiState.value.preparingItemsNum.forEach {
                        Box(
                            modifier = Modifier.size(150.dp, 100.dp)
                                .background(Color(0xff2C2C2C), RoundedCornerShape(12.dp))
                                .padding(5.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                "${it}", style = TextStyle(
                                    color = Color.White,
                                    fontSize = 24.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            )
                        }
                    }
                }
            }
        }
        Box(
            modifier = Modifier.fillMaxHeight()
                .weight(0.4f)
                .background(Color(0xff111111)).padding(vertical = 30.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(
                    "Ready جاهز", style = TextStyle(
                        color = Color.White,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
                FlowRow(
                    modifier = Modifier.padding(vertical = 10.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    uiState.value.readyItemsNum.forEach {
                        Box(
                            modifier = Modifier.size(150.dp, 100.dp)
                                .background(Color(0xff38AD63), RoundedCornerShape(12.dp))
                                .padding(5.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                "${it + 1}", style = TextStyle(
                                    color = Color.White,
                                    fontSize = 24.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            )
                        }
                    }
                }
            }
        }
    }
}