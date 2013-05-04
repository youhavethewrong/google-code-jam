"""
Minimizing scalar product of two vectors with one permutation for each vector.
Uses a genetic algorithm to minimize.

Copyright ESC 2013
    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
"""

import random
import sys

class Member:
    minimum = -1000
    maximum = 1000

    def __init__(self, x=random.randint(minimum,maximum), y=random.randint(minimum,maximum)):
        self.x = x
        self.y = y

    def permute(self, vector):
        return sum([self.x * self.y * n for n in vector])

class GeneticOptimizer:
    def __init__(self, vector):
        self.gen = 0
        self.brood_size = 40 
        self.max_gen = 100
        self.crossover_rate = 0.7
        self.mutation_rate = 0.001
        self.brood = []
        self.brood_fitness = []
        self.vector = vector

    def optimize(self):
        # generate this generation of members, and calculate their fitness
        for i in range(self.brood_size):
            self.brood.append(Member())
            self.brood_fitness.append(self.brood[i].permute(self.vector))

        return max(self.brood_fitness), self.gen

    def generate_descendants(members, crossover_rate, mutation_rate):
        """
        - generate a fitness score for each member
        - use roulette method to pick pairs
        """
        pass


def main():
    fh = open(sys.argv[1], 'r')
    cases = int(fh.readline())
    case_info = {}
    for i in range(cases):
        case_info[i] = {'len':int(fh.readline()), 
                        'x':fh.readline()[:-1].split(" "), 
                        'y':fh.readline()[:-1].split(" ")}

    for case in case_info:
        info = case_info[case]
        vector = scalar_product(info['len'], info['x'], info['y'])
        print "Vector: %s" % vector
        result,gens = GeneticOptimizer(vector).optimize()
        print "Got result %s after %s generations." % (result, gens)

def scalar_product(length, v1, v2):
    result_vector = [0 for i in range(length)]
    for i in range(length):
        result_vector[i] = int(v1[i]) * int(v2[i])
    return result_vector

if __name__ == '__main__':
    main()
