# Simple App with Paging 3, Clean Architecture, and Hilt Dependency Injection

# Overview

This is a lightweight Android application demonstrating the implementation of Paging 3 with Clean Architecture principles. The app was designed and developed within 3 hours, showcasing a single screen displaying paginated movie data retrieved from the TMDB API.

The project leverages Hilt for Dependency Injection, ensuring modularity and scalability while maintaining clean separation of concerns.
# 
# Features

Single Screen UI: Displays a list of movies using a RecyclerView.

Paging 3 Integration: Efficiently loads data in chunks to optimize performance and user experience.

Clean Architecture: Structured with clear layers: Data, Domain, and Presentation.

Hilt for Dependency Injection: Simplifies dependency management across layers.

Error Handling: Basic error handling for failed API calls.Simple App with Paging 3, Clean Architecture, and Hilt Dependency Injection
#
# Overview

This is a lightweight Android application demonstrating the implementation of Paging 3 with Clean Architecture principles. The app was designed and developed within 3 hours, showcasing a single screen displaying paginated movie data retrieved from the TMDB API.
Architecture
# 
The project adheres to Clean Architecture principles with the following layers:

#### 1-Data Layer:

Responsible for interacting with the TMDB API and providing data to the domain layer.

Uses Retrofit for network communication and PagingSource for pagination.

#### 2-Domain Layer:

Contains business logic and use cases.

Includes the GetMoviesListUseCase to interact with the data layer and provide results to the presentation layer.

#### 3-Presentation Layer:

Displays the data to the user using a RecyclerView with a PagingDataAdapter.

Integrates ViewModel (MVVM) for managing UI-related data and lifecycle-aware components.

# Libraries and Tools Used

#### 1-Paging 3: For efficient data loading and pagination.

#### 2-Hilt: For dependency injection.

#### 3-Retrofit: For HTTP requests.

#### 4-Gson: For JSON parsing.

#### 5-ViewModel: For UI-related data management.

#### 6-Kotlin Coroutines: For asynchronous operations.

#### 7-RecyclerView: For displaying the paginated list of movies.

# Screenshots
Here is demo gif to display the Pagination(note that progress bar appears in short time cause the internet speed)

![ezgif-4-02145a3ad0](https://github.com/user-attachments/assets/ab605928-0ac5-4d25-86e6-7de4bcca9bc5)
