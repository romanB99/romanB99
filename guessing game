#GUESSING GAMEEE

import random
attempts = []
def score():
    if len(attempts) <= 0:
        print("you haven't guessed yet !")
    else:
       print("your number of attempts  currently is {score}".format(score=len(attempts)))
def start_game():
    random_number = random.randint(1,20)
    print("Hello welcome to the game")
    name = input("what is your name? : ")
    wanna_play = input("Hi would you like to play {}? , ENTER [yes | no] " .format(name))
    while "yes" in wanna_play.lower():
        try:
            guess = int(input("guess a number between 1 and 20 :"))
            if guess < 1 or guess > 20:
                raise ValueError("guess a number within the given range")
            if guess == random_number:
                print("congratulation! you guessed the number:", random_number)
                attempts.append(guess)
                score()
                print("your guesses were:{}".format(attempts))
                play_again = input("Would you like to play again? (Enter Yes/No) ")
                attempts.clear()
                random_number = int(random.randint(1, 20))
                if "no" in play_again.lower() :
                   # print("Have a nice day {} see you soon".format(name))
                    break
            elif guess < random_number:
                 print("It's higher")
                 attempts.append(guess)
                 score()
            elif guess > random_number:
                 print("It's lower")
                 attempts.append(guess)
                 score()
        except ValueError as err:
            print("that not a valid guess please try again")
    print("Have a nice day {} see you soon".format(name))
start_game()



