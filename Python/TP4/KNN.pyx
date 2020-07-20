#!/usr/bin/env python
# coding: utf-8

import numpy as np
import operator


def getNeighbours(training, test, k):
    distances = [(x, np.linalg.norm(test[1:] - x[1:])) for x in training]
    distances = sorted(distances,key=operator.itemgetter(1))
    neighbours = [distances[i][0] for i in range(k)]
    return neighbours


def KNN(train,test,k):
    neighbours = np.array(getNeighbours(train, test, k))
    sorted_neighbours = np.sort(neighbours[:,0])
    cat=list(set(sorted_neighbours))
    votes=np.array([[c, len(sorted_neighbours[sorted_neighbours == c])] for c in cat])
    result=sorted(votes, key=operator.itemgetter(1), reverse=True)[0][0]
    return result
