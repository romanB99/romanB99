# Rock Paper Scissors
import random
rock = 1
paper = 2
scissors = 3
choices = {"rock" : 1  , "paper" : 2 , "scissors" : 3}
choices2 = {1 : "rock" , 2 : "paper" , 3 : "scissors"}
name = input("enter your name :")
wanna_play = input("want to play ? ENTER[yes/no] :" )
def win(a,comp):
    if ((comp==rock and a==scissors) or (comp==paper and a==rock) or (comp==scissors and a==paper)):
        print("computer wins, better like next time")
    elif ((comp==rock and a==paper) or (comp==paper and a==scissors) or (comp==scissors and a==rock)):
        print("congrats {}".format(name))
    elif comp==a:
       print("its a tie {}".format(name))
       play()
def play():
    try:
        while "yes" in wanna_play.lower():
            guess = str(input("please choose rock paper or scissors : "))
            comp = random.randint(1,3)
            a = choices[guess]
            print("{} you entered {} and computer {}".format(name,guess,choices2[comp]))
            win(a,comp)
            play_again = input("would you like to play again {}, ENTER[yes or no]: ".format(name))
            if "no" in play_again.lower():
                print("see ya {} ".format(name))
                break
            else :
                play()
            print("see ya {} ".format(name))
    except:
        print("something went wrong")
play()



