Use this file to record your reflection on this assignment.

What are your initial impressions of how `Unit Testing` affects your programming?
What worked, what didn't, what advice would you give someone taking this course in the future?

I found unit testing to be very helpful in checking my code, and it definitely seems like something I might use in the future. 
- My testEngineConstructor test checks to make sure the engine constructor initializes all of the class's global variables correctly. 
- My testEngineGo test checks to make sure the go() function decreases the engine's fuel by the amount I intended and to make sure that the go() function never decreases the fuel level below zero. 
- My testCarAddPassenger test checks to see if (a) a passenger is not on the car before trying to board, (b) a passenger is on the car after trying to board a car with space, and (c) a passenger is not on the car after trying to board a car without space (using the Car class boarding function).
- My testCarRemovePassenger test checks to make sure a passenger is not successfully removed from a car they are not on and to make sure a passenger is successfully removed from a car they are on.
- My testPassengerBoardCarWithSpace test makes sure a passenger does successfully board a car when there is space on the car (using the Passenger class boarding function).
- My testPassengerBoardCarFull test makes sure a passenger does not board a car when there is no space on the car (using the Passenger class boarding function).
- My testTrainConstructor test makes sure that the Train constructor initializes the right number of Cars. It does not test whether the Engine is successfully constructed, since there is a separate test for that (testEngineConstructor). It also does not test whether the constructor makes the Cars themselves correctly, since a different test essentially does that (testTrainGetCar).
- My testTrainPassengerCount test makes sure that the train has the right number of seats remaining both before adding a passenger, after adding a passenger, and after removing that passenger.
- My testTrainGetCar test makes sure that the Car returned by the Train's getCar() function has the intended number of passengers on board and the intended number of free seats.
- My testTrainPrintManifest test makes sure that the Train's printManifest() function iterates through the cars in the expected order and prints out the expected information from each car. To write this function, I did a Google search on how to run JUnit tests on System outputs, and I used the information I found on the site Baeldung.

Looking back at this assignment, I think I would have had an easier time if I had added some unit tests of my own in order to further split up the assert statements. I highly recommend this strategy to anyone taking this course in the future. If I've learned anything, it's that the more specific unit tests are, the easier they are to write. I also had some confusion on how to compile my test code, if I was even supposed to compile it. If that becomes a problem, I'm sorry about that. A Google search did not resolve my confusion there.