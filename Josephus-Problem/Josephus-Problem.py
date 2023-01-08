import time

class Gere :
    def __init__(self, value) :
        self.value = value
        self.next=None

class Josephus :
    def __init__(self) :
        self.head = None
        self.length=1
    
    def AddـParticipant (self,value) :
        self.value=value
        First_Person=Gere(1)
        self.head=First_Person
        for i in range(2 , value+1):
            First_Person.next = Gere(i)
            First_Person=First_Person.next
            self.length+=1
        First_Person.next=self.head

    def Kill_Participants (self,unlucky):
        Start = time.time()
        Round = 0
        next_print= self.value // 10
        First_Person = self.head  
        self.print(0," \U00002694")
        while unlucky<=self.length :
            print("/////////////// Round "+ str(Round+1)+" ///////////////// \n")

            for i in range(1,unlucky-1):
                First_Person=First_Person.next

            pre_Person=First_Person
            print("The Sword is in "+str(pre_Person.value)+"'s hand."+ " \U0001F5E1")

            for i in range(1):
                First_Person=First_Person.next

            if First_Person == self.head :
                self.head=self.head.next
                
            pre_Person.next=First_Person.next
            print(str (pre_Person.value)+" killed "+str(First_Person.value)+ ". \U0001F602 \n")
            self.length-=1
            Round +=1
            First_Person=First_Person.next


            if self.value<10 :
                self.print("Remaining" , " \U0001F642")

            elif next_print == Round :
                self.print("Remaining" , " \U0001F642")
                next_print += self.value // 10

        if self.length >1 :
            self.print("Winners" , " \U0001F389\U0001F387\U0001F3C6")
        else:self.print("Winner"," \U0001F389\U0001F387\U0001F3C6")

        print( "The whole performance took "+ str(time.time()-Start) + " Second.\n" )

    def print (self,Round=0 ,emogi = ""):
        rounds="Round "
        if Round == "Winner" or Round == "Winners" or Round == "Remaining" :
            rounds =""
        print("\n/////////////// "+rounds+ str(Round)+ emogi+" /////////////////\n")
        First_Person = self.head
        for i in range(self.length) :
           print(First_Person.value,end="\t")
           First_Person=First_Person.next
        print("\n")

def Tournament (Data_from_King):
    Data_from_King = Data_from_King.split()    
    try :

        if int(Data_from_King[0]) == 0 :
            print ("")
        if int(Data_from_King[1]) == 0 :
            print ("")
        while int(Data_from_King[1])>int(Data_from_King[0]):
            Data_from_King[1]=int(Data_from_King[1])-int(Data_from_King[0])

        Live = Josephus()
        Live.AddـParticipant(int(Data_from_King[0]))
        Live.Kill_Participants(int(Data_from_King[1]))            
    
    except ValueError :
        print()

    except IndexError :
        print()




Tournament( input("\nPleas write 2 numbers \n First number for Participants \n Second number for the Unlucky Person \n Like 25 3 : \n"))




        
        


