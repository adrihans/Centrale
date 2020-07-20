import numpy as np

def ehrenfest_return_time(N, mu):
    """
    function ehrenfest_return_time(N, mu) simulating the return time of the chain to state 0 
    @Inputs :
        - N, int : the number of particles
        - mu, array : the initial distribution
    @Outputs :
        -return_time, int : the return time to 0
    """
    P=create_P(N)
    next_step=np.random.choice(N+1, p=mu)
    return_time=0
    step=1
    while step != 0:
        next_step=np.random.choice(N+1, p=P[next_step])
        return_time+=1
        step=next_step
    return return_time

def create_P(K):
    """
    Function create_P : to compute the transition matrix P associated with the Ehrenfest model
    @Inputs : 
        K : int, the number of states considered in the markov chain 
    @Outputs : 
        the transition matrix associated with the Ehrenfest model 
    """
    upper_diag = [(K-n)/K for n in range (0,K)]
    lower_diag =[n/K for n in range (1,K+1)]
    #Transition matrix P :
    return np.diag(upper_diag, k=1) + np.diag(lower_diag, k=-1)