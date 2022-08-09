# To-do Application

To run the project, just clone it to GitHub desktop, and run it using IntellJIdea IDE. Everything should be running. You can access the webpage using http://localhost:8080/ once the application is running.

## Design Document  

Kadam Patel, Chris Royce, Jaspreet Singh, Raj Sekhon, Yoshua Meatchem

## Introduction 

We are creating a web application that lets the user add/edit/delete To-Do list. Each to-do list will have an image associated with it.

## Storyboard
![StoryBoard](https://user-images.githubusercontent.com/71667958/173663838-e1d6e197-18a9-40e4-bcba-6c18a0b8f9ef.png)

## Functional Requirements  
* As a User
* I want to be able to use the To do List feature
* So that I can add tasks to the to do list

- **Given**: I want to add a task
- **When**: I click the add button
- **Then**: A dialogbox pops up, we add the note, and then it is displayed.

* As a User
* I want to be able to use the To do List feature
* So that I can edit tasks to the to do list

- **Given**: I want to edit a task
- **When**: I click the edit button
- **Then**: A dialogbox pops up, I edit the note, and then the edited note is displayed.

* As a User
* I want to be able to use the To do List feature
* So that I can delete tasks to the to do list

- **Given**: I want to delete a task
- **When**: I click the delete button
- **Then**: The specified task is deleted from the list.

* As a User
* I want to be able to use the image feature
* So that I can add/view/delete the associated image with each task.

- **Given**: I want to add/view/delete an image. 
- **When**: I click the image Thumbnail.
- **Then**: 3 options appear - Select/Change/Delete. Then, browse window opens up and we select the image.

- **Given**: I want to add an image. 
- **When**: I click the image Thumbnail, and try to select a format other than png/jpeg for the image.
- **Then**: The user gets an error.

* As a User
* I want to be able to use the authentication feature
* So that I can keep my notes protected and not be viewed by any unauthenticated party.

- **Given**: The user has an account and has the correct Email and password
- **When**: The user clicks the log in button, and enters the correct credentials.
- **Then**: The user sees the tasks and data associated with their account. 

- **Given**: The user does not have the correct Email and password
- **When**: The user clicks the log in button, and enters the incorrect credentials.
- **Then**: The user sees an authentication error message.

- **Given**: The user does not have an account and wants to make one.
- **When**: The user clicks the register button.
- **Then**: The user fills out his/her information and registers an account. 


## Class Diagram
![image](https://user-images.githubusercontent.com/71667958/169721003-52fe47b8-6f1f-4163-a61b-ba6c6a086275.png)

### Class Diagram Description

* DTO
1) Task: Task class
2) Image: Image class

* UI 
1) HomeScreen: This will be the main screen
2) AddNote: Dialogbox for adding a note
3) AddImage: Dialogbox for adding an image
4) EditNote: Dialogbox for editing a note
5) EditImage: Dialogbox for selecting a new image.

* Service
1) ITaskService: Interface to contain all the abstract methods.
2) Task Service: Task service logic will handle the adding, editing, and deleting logic along with exceptions.

* DAO
1) IUserDAO: User authentication information will be saved in the Firebase cloud database.
2) ITaskDAO: Task data will be saved in a database. Database not yet decided. 

## JSON Schema
This is what we plan to export to another app.

{ "type" : "object", "properties" : { "name" : { "type" : "string" }, "user" : { "type" : "string" } } }

## Scrum Roles

- DevOps/Product Owner/Scrum Master: Kadam Patel 
- Business logic and persistence: Raj Sekhon, Chris Royce
- UI Specialist: Jaspreet Singh, Yoshua Meatchem

## Weekly Meeting

2 weekly meetings

Tuesdays at 1pm
Thursdays at 9pm

We will be working on a lot of things together during meetings. 

## Definition of Done

- A branch is considered Done, and added to the main branch, when at least 2 other group members have reviewed the branch changes, and approve it. Given that the program runs and nothing breaks.

## Project Link:
[- https://github.com/patel2kd/IT-4045C/blob/main/README.md](https://github.com/patel2kd/IT-4045C)
