#!/usr/bin/env python
import os
import sys

if __name__ == "__main__":
<<<<<<< HEAD
    os.environ.setdefault("DJANGO_SETTINGS_MODULE", "wpproject.settings")
=======
    os.environ.setdefault("DJANGO_SETTINGS_MODULE", "mysite.settings")
>>>>>>> 3721c405701b5af9cb693ae4bd9d456e6a346f1f

    from django.core.management import execute_from_command_line

    execute_from_command_line(sys.argv)
