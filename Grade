
text = input("enter your text : ")

chars = len(text)
word_list = text.split()
words = len(word_list)
commas = text.count(',')
Sentences = text.count('!') + text.count('.') + text.count('?')
letters = chars - commas - words
L = (letters/words)*100
S = (Sentences/words)*100
index = 0.0588 * L - 0.296 * S - 15.8
if index < 1:
    print("Before Grade 1")
elif index > 16:
    print("Grade 16+")
else:
    print(f"Grade is : {int(index+0.5)}")
