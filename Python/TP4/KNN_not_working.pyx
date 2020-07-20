#!/usr/bin/env python
# coding: utf-8

import numpy as np
import operator

cimport numpy as np
DTYPE = np.float

def getNeighbours(float[:,:] train, float[:] test, int k):
    cdef tuple[:] distances = [(x, np.linalg.norm(test[1:] - x[1:])) for x in train]
    distances = sorted(distances,key=operator.itemgetter(1))
    cdef float[:,:] neighbours = [distances[i][0] for i in range(k)]
    return neighbours


def KNN(float[:,:] train, float[:] test, int k):
    cdef float[:,:] neighbours = np.array(getNeighbours(train, test, k))
    neighbours = np.sort(neighbours[:,0])
    cdef float[:,:] cat = list(set(neighbours))
    cdef float[:,:] votes = np.array([[c, len(neighbours[neighbours == c])] for c in cat])
    cdef int result = sorted(votes, key=operator.itemgetter(1), reverse=True)[0][0]
    return result
