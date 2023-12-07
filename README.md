# FaceLite - A Simple Social Networking Application


## Table of Contents

1. [Introduction](#introduction)

2. [Project Overview](#project-overview)

3. [Getting Started](#getting-started)

4. [How to Use](#how-to-use)

5. [Main Class](#main-class)

6. [BuildScreen Class](#buildScreen-class)

7. [Profile Class](#profile-class)

8. [Adding Class](#adding-class)

9. [Changing Class](#changing-class)

10. [Content Class](#content-class)

11. [Users Class](#users-class)


## Introduction

FaceLite is a straightforward social networking application developed in Java. The project aims to simulate a basic social network where users can create profiles, connect with friends, and share their current status.  
 
## Project Overview

The FaceLite application manages the information in a simple social network using JavaFX. Users can perform the following actions:

- Add a new profile

- Delete a profile

- Look up a profile

- Change the current status

- Change the current profile image

- Add friends to a profile


## Getting Started

To run the FaceLite application, follow these two steps:

1. Open the project in your preferred Java IDE.

2. Run the `Main` class.
  

## How to Use

1. Launch the application.

2. Use the "Add" button to create a new profile.

3. Use the "Delete" button to remove a profile.

4. Use the "Lookup" button to search for a profile.

5. Use the "Change Status" and "Change Picture" buttons to update user information.

6. Use the "Add Friend" button to connect with other profiles.

  
## Main Class

The `Main` class goal is to start the application using a method named start.

The `Main` class is used to call the `BuildScreen` class in order to proceed in the application. 

## BuildScreen Class

The `BuildScreen` class goal is mainly concerend with the stage and setting all its' alignments, calling most of the classes of the project, such as `Adding` class, `Changing` class, and `Content` class. Furthermore, keeps updating the data shown on the screen.


## Profile Class

The `Profile` class goal is mainly concerend with the profile of each user, each user has a unique profile consisting of a name, image, status, and a list of friends.
The profile class uses the `Adding`, `Changing` classes to manipulate the profile from each user by getting the information that is needed to be changed by these classes.

## Adding Class

The `Adding` class is one of the base classes in the project, where it can change many information, it can add, delete, or lookup a profile. Furthermore, it changes some of the displayed information using the `Content` and `Updated` classes.

- Add button is concered with adding a new profile.
- Delete button is concered with deleteing an existing profile.
- Lookup button is concered with searching an existing profile.

## Changing Class

The `Changing` class is one of the base classes in the project, where it can change many information, it can change the status, picture, and add friends. Furthermore, it changes some of the displayed information using the `Content`, `Updated`, and `Users` classes.

- ChangeStatus button is concered with changing the status of an existing profile.
- ChangePicture button is concered with changing the picture of an existing profile.
- AddFriend button is concered with add with an existing friends to the an existing profile.
- `Changing` class stores the new information gotten from the text fields into the `Users` class.


## Content Class

The `Content` class is one of the base classes in the project and it is part of the `BuildScreen` , where it can change many information, this class is concerned with the bottom right of the program display (name, picture, status, friends, and the massage in the bottom) where it is mainly (updating) the actual profile displayed and the massages that are shown in the bottom using the `Users`, and `Updated` classes.


## Updated Class

The `Updated` class is a simple-short class designed to control the massages displayed in the bottom of the application, it displays what action have happened recently and did the program accept the action or not (I would show that the action did not happen, for instance, if the user tried to change some information of non existing profile ), and it is called by each class since each class wants the massage displayed in a different form or text.

## Users Class
The `Users` class is one of the main classes of the project since it stores the information of each user.

This class uses dictionary to store the information, taking the name of the user as a key and (status, picture, friends) as a value, it also checks whether a certain username already exists or not by search in the dictionary using the key name, many other classes use this class in-order to get the information of users and handle them accordingly.