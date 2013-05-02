"""

"""

import sys

def scalarProduct(l, v1, v2):
    product = 0
    for i in range(l):
        print "%s * %s" % (v1[i], v2[i])
        product += int(v1[i]) * int(v2[i])
    return product
        
if __name__ == '__main__':
    fh = open(sys.argv[1], 'r')
    cases = int(fh.readline())
    case_info = {}
    for i in range(cases):
        case_info[i] = {'len':int(fh.readline()), 
                        'x':fh.readline()[:-1].split(" "), 
                        'y':fh.readline()[:-1].split(" ")}

    for case in case_info:
        info = case_info[case]
        print scalarProduct(info['len'], info['x'], info['y'])
