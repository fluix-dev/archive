Avid Dev - August 9, 2019

Bonus: Attempted

Example below: Number of trials is 5, each with 1000 flips.

Random number
  Generated
     \/

*************************************************************************
* Coin Flip * Trial   1 * Trial   2 * Trial   3 * Trial   4 * Trial   5 * <== Header
*************************************************************************
*     1     *       55  *       55  *       50  *       68  *       64  * <== Number of 1s genereated in each trial
*     2     *      120  *       99  *       97  *      120  *      102  * <== Number of 2s ...
*     3     *      114  *      122  *      102  *      122  *      107  * 
*     4     *      113  *      127  *      129  *      111  *      110  *
*     5     *      105  *      119  *      105  *      108  *      118  *
*     6     *      102  *      107  *      117  *      100  *      107  *
*     7     *      132  *      112  *      114  *      126  *      120  *
*     8     *       94  *      103  *      121  *       87  *      113  *
*     9     *      109  *      102  *      101  *      119  *       91  * <== Number of 9s ...
*    10     *       56  *       54  *       64  *       39  *       68  * <== Number of 10s generated in each trial
*************************************************************************
*    Most   *        7  *        4  *        4  *        7  *        7  * <== First highest number generated
*   Common  *    Tails  *    Heads  *    Heads  *    Tails  *    Tails  * <== Where it is 
*************************************************************************

Sums of above:

*************************
* Coin Flip *   Total   *
*************************
*     1     *      292  * <= Number of 1s generated in total
*     2     *      538  * ...
*     3     *      567  * ..
*     4     *      590  * .
*     5     *      555  *
*     6     *      533  *
*     7     *      604  *
*     8     *      518  *
*     9     *      522  *
*    10     *      281  *
*************************
*    Most   *        7  *
*   Common  *    Tails  *
*************************