# App Architecture #1

## Content

### Components
- **MainScreen** is the mother component of MainActivity.kt
- **InputComponent** contains an OutlinedTextField and a Button to trigger an event when clicked.
- **ResultComponent** contains a LazyVerticalStaggeredGrid which renders Result composables.
- **Result** contains a Card displaying a String value

### API
Fetch age based on name input form [Agify]([https://www.example.com](https://agify.io/documentation))

### Overview of app
(![overview of app architecture](https://github.com/user-attachments/assets/ec04bfc9-ffb0-4a96-9095-0405ca23edda))

## TODO
- Implement the NameViewModel containing a list of names 
- Use viewmodel to keep track of names
- Fetch data from a simple data source from the AgeRepository
- Show the names in MainScreen when they are available in the NameViewModel
