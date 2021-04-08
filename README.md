# Songr App

`/`
- Displays home/splash page
- Contains a user-populated form to add an image URL, album title, artist name, album length, and amount of tracks/song count
- On submission reroutes to /albums

`/albums`
- Uses Thymeleaf to loop findAll in the albumRepository
- Displays all user-entered albums
- Each album has a button that reroutes to the /songs route
- Each album has a button that deletes the album and refreshing the page

`/songs`
- Displays the album based on the SQL id included in the route and pulled from the /albums route
- Uses Thymeleaf to loop first through the album based on the route ID, displaying it's details
- Loops a second thyme through the `songs` relationship with the Album model and displays all songs related to the specific album
- Includes a form to add a new song Title, length and track# through the ManyToOne relationship with the Album
- Includes a delete button that takes in the ID of both the song and the album and deletes the song from the SQL database by ID and uses the song ID to reroute back to the same page

`gradle bootrun` to run app and then wait a year or two for it to maybe work idk it sticks at 80% and sometimes the localhost:8080 works but also sometimes it doesn't