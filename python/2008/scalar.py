"""
Minimizing scalar product of two vectors with one permutation for each vector.

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

import sys

def scalar_product(v1, v2):
    scalar = 0
    for i in range(len(v1)):
        scalar += int(v1[i]) * int(v2[i])
    return scalar

def minimize(v1, v2):
    v1.sort()
    v2.sort()
    v2.reverse()
    return scalar_product(v1, v2)

def main():
    fh = open(sys.argv[1], 'r')
    cases = int(fh.readline())
    case_info = {}
    for i in range(cases):
        case_info[i] = {'len':fh.readline(),
                        'x':fh.readline()[:-1].split(" "), 
                        'y':fh.readline()[:-1].split(" ")}

    for case in case_info:
        info = case_info[case]
        scalar = minimize(info['x'], info['y'])
        print "Case #%s: %s" % (case+1, scalar)

if __name__ == '__main__':
    main()
