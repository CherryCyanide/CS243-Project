
#include <stdlib.h>
#include <stdio.h>

// ----------------------------------------------------------------------------
//
// CS 243 Programming assignment
// Written by Michael Walker
// February, 2026
//
// Date-related functions - Day of week, month and day names, etc.
//
// ----------------------------------------------------------------------------


// #define DEBUG

#ifdef DEBUG

// Testing entry point.  To activate, un-comment the above #define for DEBUG, and recompile

int main(int argc, char **argv)
    {
    int mon, day, yr, wk_day;
    int day_num(); 
    char *day_nm(), *day_name(), *mon_nm(), *mon_name(), *day_suffix();

    if(argc < 3)
        {
        printf("\n Error: Needs 3 args: mon, day, year\n");
        exit(0);
        }

    mon = atoi(argv[1]);
    day = atoi(argv[2]);
    yr = atoi(argv[3]);

    wk_day = day_num(mon, day, yr);

    printf("\n   %s, %s %d%s, %d falls on a %s in %s\n\n", 
        day_nm(wk_day), mon_nm(mon), day, day_suffix(day), yr, 
        day_name(wk_day), mon_name(mon));  

    exit(0);
    }

#endif

// ----------------------------------------------------------------------------
//
// Methods of linking to Java code:
//
// Your options include:
//
// Java Native Interface
//
// see: https://en.wikipedia.org/wiki/Java_Native_Interface
//
// JNI enables programmers to write native methods to handle situations when an 
// application is not written entirely in the Java programming language, 
//
//     - or -
//
// Java Native Access
//
//    see: https://en.wikipedia.org/wiki/Java_Native_Access
//
// To access from Java:
//
// Java Native Access is a community-developed library that provides Java programs 
// easy access to native shared libraries without using the Java Native Interface.
//
// Another Alternative:
//
// JNR-FFI
//
//    see: https://github.com/jnr/jnr-ffi
//
//  jnr-ffi is a java library for loading native libraries without writing JNI 
//  code by hand, or using tools such as SWIG.
//
// ----------------------------------------------------------------------------



// 
// int day_num()
//
// Given a a month (1-12), a day (1-31) and a 4-digit year, will return a day of 
// the week, encoded as: 1 = Monday, 2 = Tuesday, etc.
//
//

int day_num(int mon, int day, int yr)
    {
    int wkday;

    if(mon < 3)   // treat Jan & Feb as months 13 & 14 of prev year
        {
        mon += 12;
        yr--;
        }
    
    wkday = (day + 2 * mon + 3*(mon+1)/5 + yr + yr/4 - yr/100 + yr/400) % 7;

    return(wkday);
    }


//
// char *day_name()
//
// Given a day of the week, 1 = Monday, 2 = Tuesday, etc., will return a pointer to a day
// name. (Monday, Tuesday, etc.)
//

char *day_name(int day_num)
    {
    char *names[] = {"Monday","Tuesday", "Wednesday", 
        "Thursday", "Friday", "Saturday", "Sunday"};

    return(names[day_num]); 
    }


//
// char *day_nm()
//
// Given a day of the week, 1 = Monday, 2 = Tuesday, etc., will return a pointer to a day
// name abbreviation. (Mon, Tue, etc.)
//

char *day_nm(int day_num)
    {
    char *names[] = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
    
    return(names[day_num]);
    }


//
// char *mon_name()
//
// Given a month number, (1 = January, 2 = February, etc.), will return a pointer to a month
// name. (January, February, etc.)
//

char *mon_name(int mon)
    {
    char *months[] = {"", "January", "February", "March", "April", "May",
      "June", "July" "August", "September", "October", "November", "December"};

    if(mon < 1 || mon > 12)
        return(months[0]);

    return(months[mon]);
    }


//
// char *mon_nm()
//
// Given a month number, (1 = January, 2 = February, etc.), will return a pointer to a month
// name abbreviation. (Jan, Feb, etc.)
//

char *mon_nm(int mon)
    {
    char *months[] = {"", "Jan", "Feb", "Mar", "Apr", "May",
        "Jun", "Jul" "Aug", "Sep", "Oct", "Nov", "Dec"};

    if(mon < 1 || mon > 12)
        return(months[0]);

    return(months[mon]);
    }


//
// char *day_suffix()
//
// Given a day number, (1 - 31), will return a pointer to the correct day suffix
// ("st" for 1st, "nd" for 2nd, etc.)
//

#define NONE 0
#define ST   1
#define ND   2
#define RD   3
#define TH   4

char *day_suffix(int day)
    {
    char *suf[] = {"", "st", "nd", "rd", "th"};

    switch(day)
        {
        case 1:
        case 21:
        case 31:
            return(suf[ST]);
        case 2:
        case 22:
        case 32:
            return(suf[ND]);
        case 3:
        case 23:
        case 33:
            return(suf[RD]);
        default:
            if(day == 0)
                return(suf[NONE]);
            else
                return(suf[TH]);
        }

    return(suf[NONE]);
    }

// ----------------------------------------------------------------------------
