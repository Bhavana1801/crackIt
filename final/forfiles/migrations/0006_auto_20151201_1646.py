# -*- coding: utf-8 -*-
from __future__ import unicode_literals

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('forfiles', '0005_auto_20151201_1642'),
    ]

    operations = [
        migrations.AlterField(
            model_name='profileimage',
            name='image',
            field=models.FileField(upload_to=b''),
        ),
    ]
