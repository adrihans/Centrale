from distutils.core import setup
from Cython.Build import cythonize
import numpy

setup(
    ext_modules = cythonize(["KNN.pyx", "KNN_not_working.pyx"]),
    include_dirs=[numpy.get_include()]
)
