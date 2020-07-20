#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Wed Feb  7 14:46:02 2018

@author: johnklein
"""


import tensorflow as tf
# if the import fails, try to install tf : pip install --upgrade tensorflow
import numpy as np
import os
import sys
import matplotlib.pyplot as plt

# to work on the same dataset as students
def reset_graph(seed=42):
    tf.reset_default_graph()
    tf.set_random_seed(seed)
    np.random.seed(seed)


################
#Dataset import#
################

from tensorflow.examples.tutorials.mnist import input_data
mnist = input_data.read_data_sets("/tmp/data/")

##########################
#PCA with an auto-encoder#
##########################

reset_graph()

d_inputs = 28 * 28
d_hidden1 = 300
d_hidden2 = 150  # codings
d_hidden3 = d_hidden1
d_outputs = d_inputs

learning_rate = 0.01
l2_reg = 0.0005

initializer = tf.contrib.layers.variance_scaling_initializer()
activation = tf.nn.elu
regularizer = tf.contrib.layers.l2_regularizer(l2_reg)

#Input data
X = tf.placeholder(tf.float32,shape=[None, d_inputs])

#Hidden layer1 (code generating layer)
weights1_init = initializer([d_inputs, d_hidden1])
weights1 = tf.Variable(weights1_init, dtype=tf.float32, name="weights1")
biases1 = tf.Variable(tf.zeros(d_hidden1), name="biases1")
hidden1 = activation(tf.matmul(X, weights1) + biases1)

#Hidden layer2 (code generating layer)

#Hidden layer3 (intermediate representation reconstruction layer)

#Output layer (input reconstruction)

#Objective function: MSE + L2 penalty
reconstruction_loss = tf.reduce_mean(tf.square(outputs - X))
reg_loss = regularizer(weights1) + regularizer(weights2)
J = reconstruction_loss + reg_loss

optimizer = tf.train.AdamOptimizer(learning_rate)
training_op = optimizer.minimize(J)

init = tf.global_variables_initializer()

n_epochs = 5
batch_size = 150

with tf.Session() as sess:
    init.run()
    for epoch in range(n_epochs):
        n_batches = mnist.train.num_examples // batch_size
        for iteration in range(n_batches):
            print("\r{}%".format(100 * iteration // n_batches), end="")
            sys.stdout.flush()
            X_batch, y_batch = mnist.train.next_batch(batch_size)
            sess.run(training_op, feed_dict={X: X_batch})
    


