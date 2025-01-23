# App Architecture #1

## Content

**MainScreen** is the mother component of MainActivity.kt
**InputComponent** contains an OutlinedTextField and a Button.
**ResultComponent** contains a LazyVerticalStaggeredGrid which renders Result composables.
**Result** contains a Card

## TODO
- Implement the NameViewModel containing a list of names 
- Use viewmodel to keep track of names
- Show the names when they are available in the UiState