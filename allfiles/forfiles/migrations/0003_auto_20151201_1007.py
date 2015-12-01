# -*- coding: utf-8 -*-
from __future__ import unicode_literals

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('forfiles', '0002_userdetails'),
    ]

    operations = [
        migrations.AddField(
            model_name='profileimage',
            name='domain',
            field=models.CharField(default=0, max_length=20),
            preserve_default=False,
        ),
        migrations.AddField(
            model_name='profileimage',
            name='keyword',
            field=models.CharField(default=0, max_length=20),
            preserve_default=False,
        ),
    ]
