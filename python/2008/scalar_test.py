"""
Tests for scalar.py

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

import scalar
import re
import unittest

class MemberTestCase(unittest.TestCase):
    def setUp(self):
        self.member = scalar.Member(1, 3)

    def test_permute(self):
        test_list = [3, -2, 4]
        total = 9 - 6 + 12
        self.assertEqual(total, self.member.permute(test_list))
        
    def tearDown(self):
        pass

if __name__ == '__main__':
    unittest.main()
