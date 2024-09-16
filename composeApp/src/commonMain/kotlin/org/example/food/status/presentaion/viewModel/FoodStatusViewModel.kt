package org.example.food.status.presentaion.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import org.example.food.status.presentaion.repo.FoodStatusRepository

class FoodStatusViewModel(repository: FoodStatusRepository) : ViewModel() {
    private val _uiState = MutableStateFlow(FoodStatusUiState())
    val uiState: StateFlow<FoodStatusUiState> = _uiState.asStateFlow()

    init {
        _uiState.update {
            FoodStatusUiState(
                preparingItemsNum = repository.getPreparingItems(),
                readyItemsNum = repository.getReadyItems(),
            )
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val foodStatusRepository = FoodStatusRepository()
                FoodStatusViewModel(foodStatusRepository)
            }
        }
    }
}

data class FoodStatusUiState(
    val preparingItemsNum: List<Int> = emptyList(),
    val readyItemsNum: List<Int> = emptyList(),
)

