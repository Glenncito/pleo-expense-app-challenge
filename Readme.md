## What the app does (user stories), and how it works:

As a user, you can:

     1. Switch the language of the app to any one of the 4 supported languages
     2. View a scrollable list of expenses containing the following attributes:
    	- The month and date of the expense,
    	- The currency and amount of the expense,
    	- The place where the expense was incurred (merchant),
    	- The name, surname and email address of the user,
    	- An Add or Edit button next to the comment,
    	- A button to Add a receipt
    3.  Add a comment in the comment input section which is
    	made visible by pressing the add/edit button.
    4.  Submit a receipt using the device’s camera
    5.  Use the search bar to search for a keyword contained in the name,
    	email address and merchant.

Underneath the hood, upon starting, the app does the following:

    1.  Performs an initialExpensesFetch which checks RealmDb storage for existing Expense data.
    	  1.1. If local storage is empty:
    		  a. Dispatches a ‘fetchExpensesFromAPI’ request
    		  b. The responseThe response is dispatched local model redux state
    		      in store/modules/expenses.js that feeds the
    		      FlatList located in pages/Expenses.js.
    		  c. The response is stored in the local storage.
    	  1.2. If local storage is not empty:
    		  a. The locally stored expense data is dispatched local model
    		     redux state in `store/modules/expenses.js` that feeds the
    		     FlatList located in pages/Expenses.js.
    		  b. The response is dispatched local model redux state
    		     in store/modules/expenses.js that feeds the FlatList located
    		     in pages/Expenses.js.
    		  c. The response is stored in the local storage.
    2. When the user taps the add a receipt button,
        2.1 A native android module is called to display camera mode
        2.2 When a photo is taken and approved by the user,
    	    the native module stores the photo in local file
    	    storage and returns the file name to React Native,
    	2.3 The file is to the server with Axios.
    3.  When the user taps to add or edit a comment,
        The AddComment.js modal is made visible. Upon submitting
        the comment:
        3.1 The comment is updated to the Expense object
    	    in the API via api/expenses.js:updateCommentApi
        3.2 If the previous operation is successful, the comment
    	    is also updated to the local storage via
    	    lib/helpers:updateCommentToDb.

## Known Issues

There are a few issues that I picked up during development and testing that I never managed to come back to solving due to time constraints.

### Lag in `AddComment.js` component rendering and locale switching due to large data set:

**Description:**
It is immediately noticeable when the FlatList is displaying a large data set, everything slows down. It is particularly noticeable when switching locale and trying to add a comment.

**Likely Solution:**
My research pointed me to using pagination with Redux. It seems likely that this would be an effective solution.

### Back-navigation in camera mode

**Description**:
When pressing the device back button in camera mode, the app restarts in its entirety.

**Likel`enter code here`y Solution:**
I would start by using a combination of React-Navigation and exploring the solutions discussed [here](https://stackoverflow.com/questions/45031085/react-native-device-back-button-handling) and [here](https://medium.com/building-with-react-native/android-back-button-handling-in-react-native-apps-1x08-e3acb0990011).

## Notable Libraries Used:

**Redux-Starter-Kit**
An opinionated and simplified take on Redux. It was recomended to me by my mentor when I was just starting out with learning React.

**Date-fns**
A small and well supported library that makes managing date and time really easy. It also allows for date localisation which was another big motivator for using it.

**Axios**
I ended up choosing this library because of it's popularity and how it simplifies API requests. Most of the tutorials I looked at online used Axios so I just defaulted to using it.

## What I'm unsatisfied with:

For a first bash at React Native, I am generally quite happy with what I’ve managed to learn and implement in this short period of time. That said, I had concerns about how I went about my final addition to the code, offline/online syncing, rehydration and display, and whether or not it would even be to my disadvantage to include it at all in the ‘final product’.

I ultimately decided that I would include it, accompanied by this disclaimer, for the following two reasons:

1.  It allowed me the opportunity to tick the box of utilizing RealmDb,

2.  I felt that even though I am now aware of better ways to go about this problem (it became evident to me right at the last moment through online problem solving that a much more efficient and elegant way about this would be through using Redux-Persist and the Realm extension), I still felt good about having solved a complicated problem that had occupied a lot of my time during these final days.

Given the chance, I would redo it with Redux-Persist.

## How long everything took

By the time I started working on this I had only just started learning React and my knowledge didn’t extend much beyond the default React Native components, State and Props management. I had never worked with Realm, Redux or Native Module integration. This meant that almost every aspect of this project was new to me and proved to be quite a steep learning curve from the start.

Below I will list how long each of the main components took me, as well as what, if anything, proved to be particularly challenging about said task:

    1.  Add functional Native Android Module: 2 Days
    2.  Add Realm storage and functionality: 2 Days
    3.  Implementing and using hooks: 2 Days
    4.  Upload photo to API: 1 Day
    5.  Add redux: 3.5 Days
    6.  Update comment: 1 Day
    7.  Search: 0.5 Day
    8.  Localisation of strings and date: 1 Day
    9.  Offline storage and API syncing: 3 Days
    10.  Styling: 1 Day
    11.  Git mishaps and Android Studio/Gradle dependency Nightmare: 3 days

**TOTAL**: 20 Days

In terms of struggles, as mentioned everything was a steep learning curve. But 2 things stand out:

## If I had more time:

    -   Add iOS native module (Swift)
    -   Implement Redux-Persist-Realm
    -   Offline queuing functionality for receipts and comments
    -   More advanced filtering:
    	- Filter by Date
        - Between 2 dates
        - Before a date
        - After a date
    -   Filter by User
    -   Filter by Merchant
    -   Relative Currency Display
    -   Allow the user to view all currencies relative
        to one given currency, using the conversion rate of
        the expenses date using exchangeratesapi.org
    -   This would also allow to display the total amount.
    -   Store photos taken offline in ByteArray format and
        allow for viewing submitted Receipts.

## What I struggled with

**Android studio file change and Gradle depedency issues**
at a point early on in this project I moved files around to arrange my package structure more efficiently, at which point existing classes (mainApplication, generated files) were either seen as duplicated or missing. Nothing I tried fixed it until I arbitrarily covered them to kotlin classes, but then other dependency issues and missing file issues occured.
  
None of the proposed solutions worked, there were lots of minor changes that all amount to lots of compiling, downloading new libraries and waiting. Eventually I started my android project over and copied the code across which I could have done sooner and saved more time on, but I never like to leave a problem like that solved without knowing what the actual problem and solution was.

**Adding comment via the `AddComment.js` component and Redux**
Although I imagine this to be a relatively straight forward task for a seasoned React-Native developer, this proved a steep learning curve for me as it was the first time I was having to really tap into the magic of Redux by having multiple components speak to each other as well as having one component show and hide another based on a redux state. I could have gone about this feature in a simpler manner but I chose to aproach it in this way since I believed that its technical requirements to be neccessary and valuable for my learning journey.

**Linking date localisation to the localisation redux store**
This one took quite a bit of playing around to get right. The problem is that while `Date-fns` wonderfully allows for localisation, it has its own set of constant values that determine what locale is used and assigning the relevant locale required me to escape the reference in a way that set it as the reference to the constant and not to the values of the constant. The solution involved using a localeMap and rereferencing the values like `` localeMap[`${localeConstant}`] ``, which I believe to be a bit messy.
