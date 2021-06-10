package vyvojmobilnychapk.project3.stgame2.viewModels

import androidx.lifecycle.*
import kotlinx.coroutines.launch
import vyvojmobilnychapk.project3.stgame2.Repository
import vyvojmobilnychapk.project3.stgame2.entities.Resource

class ResourceViewModel(private val repository: Repository) : ViewModel() {

    // Using LiveData and caching what allWords returns has several benefits:
    // - We can put an observer on the data (instead of polling for changes) and only update the
    //   the UI when the data actually changes.
    // - Repository is completely separated from the UI through the ViewModel.
    val allResources: LiveData<List<Resource>> = repository.allResources.asLiveData()

    /**
     * Launching a new coroutine to insert the data in a non-blocking way
     */
    fun insert(resource: Resource) = viewModelScope.launch {
        repository.insert(resource)
    }
}

class ResourceViewModelFactory(private val repository: Repository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ResourceViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ResourceViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}