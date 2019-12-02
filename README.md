Final Report
 
Vapor Studio

December 1, 2019

Dalhousie University

Mobile Computing
Fall 2019
Faculty of Computer Science

Team
Vapor Studio

Application Name
Tour Guy’d

Members
Team Lead:

Christian Gilbert-Paszkowski

Student ID: B00726153
ch393156@dal.ca

Repository:

https://git.cs.dal.ca/christian/tour-guyd


#Abstract

The Tour Guy’d application for android mobile devices is designed for users who like to travel and explore new destinations. When a traveler visits a new city, they need to do a lot of research on a host of different websites in order to find the most popular activities and attractions. When those points of interest include tour guides, that adds yet another obstacle as they must also plan their times accordingly, especially during the off-season. Tour Guy’d takes all those concerns and provides users a simple on-the-go experience that provides a list of popular attractions and creates a tour that the user can follow on their own mobile device, no additional planning necessary. All the user needs to do is login, browse the selection of tours, and follow the map around the city.
Completion Report
Now that we have reached the end of the final stage of this project, it is fair to say that the final product was not the desired outcome. Much of the planned functionality that would make this application standout and be successful in the public marketplace was either not implemented at all or not in a manner that would maintain and grow a user base. 
From the list of features that was originally planned out at the beginning of the term, I was able to complete (although not entirely as hoped) the majority of the minimum functionality, as well as some elements of the expected functionality list. Users can open the application and register a new account which then, once validated, can login to the application. Once logged in, the user no longer needs to re-enter their credentials every time they open and close the application. On the home screen is a RecyclerView list that generates a collection of different tours and attractions that the users can select from. The original idea for this feature was that it would fetch data to populate the list from the database depending on the users preferences upon registration, however I encountered some issues with the data coming from the database and was not able to resolve this issue in time. The database is connected to the application, but the data manipulation is unresolved. For this reason, I had to hardcode the primary data directly in the home activity in order to get the ClickListener to function as required for the map feature. Once a selection from the list of tours is made by the user, they are brought to the map feature which is supposed to retrieve the corresponding route from the database which as mentioned does not, however the empty map does load. With the route data, primarily geo-coordinates in the database, the application is supposed to generate the turn-by-turn navigation of the specific tour for the user to follow. Here is where another issue was encountered and not resolved regarding the navigation. The decision to use Mapbox as my map SDK was a choice based on the customization and built-in features out-of-the-box. This decision was not made without much research, however the drawback of using a third-party (non-Google) solution with high emphasis on opensource work was that there are a lot of changes being made and not always the best resources to document them. I often encountered features that were deprecated (many in recent months) and the new alternatives which were not well documented or adopted by the programming community yet. This is where I struggled to bridge the old and new information to a point that I could make use of the vast toolset that Mapbox has. From here, the remaining work was put into populating the database with the required data which is ready to be used on the partially implemented features.


#Functional Decomposition
 
Figure 1: Simplified diagram of how the application interacts
Launch/Login
When the application launches, the first thing that appears is the activity_login layout which holds a simple UI for the user. They have two options in this layout, input the required text fields and click the button to submit their login credentials or click the register button if they don’t have an account. The sign-in button has a click listener which than retrieved the inputted text fields and authenticates the user with the firebase database before returning to either deny access and notify the user, or start the main HomeActivity. The register button has a click listener that starts the RegisterActivity and loads the activity_register layout.

Register
When the RegisterActivity is started the user is shown the activity_register layout which is a similar UI to the login screen. On clicking the register button, the activity validates the fields and then submits them to the database which creates a new user entry. The activity returns to the LoginActivity to repeat the previous step.

Home
The HomeActivity is where everything in the application is connected. The activity_home layout is loaded on screen once logged in and displays a Recyclerview. The Recyclerview works with an Adapter, LayoutManager, and ViewHolder to collect, bind, and display data in the list to views. Each of these views in the list has a click listener that will then start a MapActivity.

Map
Once a MapActivity is started, Mapbox is instantiated in the map_activity layout. From here further functionality was not completed.


#High-Level Organization
 
Figure 2 Site-map of the Tour Guy'd application. Red indicates planned features
Here is the site-map for the application with the implemented features and the red outlines indicating the features which were planned but not implemented by the final stage. 
 
Figure 3 Sample of database data
Here is a sample of the database data. It was split into collection based on categories with each document being one of the tour destination which has geo-coordinates and descriptions of each location.


#Clickstreams
Given the fact that the most important part of the application in the map feature is not fully functional, it would be of no purpose to list the use cases beyond logging in to the application and viewing a list of activities.
Layout and Implementation
 
Figure 4 The wireframe of the login screen and the actual login and registration screens
Here is the Login screen and registration screen. There was no registration screen wireframe although the plan was to keep it as simple and similar to the login as possible. This view is displayed upon application launch and only requires the user to input a valid email address and password before accessing the application. When registering a new user, they must first confirm their address with a link that is emailed to them. This helps minimize fake accounts being registered.

 
Figure 5 The wireframe of the home screen and the actual screen
This is the Home screen that the user is brought to once logged in to the application. Each of the items in the list are clickable and will direct the user to a map activity. The final implementation does not have an image at the time of submission. This was initially implemented with a Cardview but was removed while debugging and was not added back due to the issue with the database.
 
Figure 6 The wireframes for the map activity and the actual screen
The two left wireframes are the original plans for the map that would show the tour route (left image) and the destination data once the user arrives (center). As mentioned, these featured were not completed and the results are an empty map.
Future Work
It goes without saying that the future iterations of this application would be to first solve the issue of retrieving and implementing the data from the database. Second, would be taking in the data to the map activity and providing a working turn-by-turn navigation feature that would complete the basics of this application. Once these features are implemented correctly the application would then be usable and I could focus on the more customized experience that I set out to provide at the beginning of the project.


#Resources and References

Database
Firebase Authentication, and Cloud Firestore were used to store and manage users and data.
https://firebase.google.com/docs/android/setup?authuser=0

Maps
The map functionality was completed with the Mapbox Maps SDK.
https://docs.mapbox.com/android/maps/overview/

Recyclerview
Recyclerview functionality was implemented with the help of the tutorial and resources provided by:
https://www.andreasjakl.com/kotlin-recyclerview-for-high-performance-lists-in-android/

Wireframes
All design work was done using Adobe Xd.
https://www.adobe.com/ca/products/xd.html

Other Resources that were referenced but not used

https://www.raywenderlich.com/378151-mapbox-tutorial-for-android-getting-started
http://blog.farifam.com/2017/10/25/android-kotlin-using-toobject-to-get-firestore-data/
https://github.com/sabithuraira/KotlinFirestore/blob/master/app/src/main/java/com/farifam/kotlinfirestore/FirestoreData.kt
https://medium.com/fnplus/cloud-firestore-kotlin-33892886ce64
https://www.youtube.com/watch?v=Jo6Mtq7zkkg
https://github.com/mapbox/mapbox-gl-native/wiki/Android-6.x-to-7.x-migration-guide#xml-attributes
