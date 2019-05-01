# Sample app
A sample application that grabs blog posts from an API and displays them. Clicking through on a blog post displays the details.

The UI isn't anything fancy, but the code for fetching the posts will attempt to cache the data once it has fetched it from the API.

There are error and loading screens implemented.

Although this is on an MVI branch, there are no state reducers, because I didn't think the state was complex enough to warrant partial state.

# Running the app
You can run the app from the command line by executing `./gradlew deployDebug` on the command line from the root folder.
