import numpy as np

"""
Inputs  :
- N : int, number of states
- rho : vector of size N summing to 1, law of the initial state.
- A : transition matrix
- nmax : number of time steps

Outputs :
-states : list of the states
"""

def Markov(N,rho,A,nmax):
    #Generating the initial state :
    a=np.arange(1,N+1)
    # To generate the initial state, we use numpy.random.choice()
    X = np.random.choice(a,p=rho)
    #Initializing the list states with the initial state :
    states=[]
    time=0
    AKK=A[X-1][X-1]
    T=np.random.geometric(AKK) #Time in the current state
    while (time<nmax): #Number of time steps
        #At instant n, knowing Xn=k :
        if T==0 : #We stay in the current state as long as T different from 0, decrementing T each time
            #Determining the next transition instant :
            AKK=A[X-1][X-1]#akk
            T=np.random.geometric(1-AKK) #T follows a geometrical variable with parameter akk
            #Determining the next state :
            #Computing the discrete law of the next state, with the transition matrix :
            Transition = A[X-1] #ak.
            #Probability of transition :
            p=[Transition[i]/(1-AKK) for i in range(N)]
            p[X-1]=0 #It is impossible to be in the same state as before
            #Generating the next state :
            X=np.random.choice(a, p=p)
        #Saving the state in the table states :
        states.append(X)
        time+=1
        T=T-1
    return states