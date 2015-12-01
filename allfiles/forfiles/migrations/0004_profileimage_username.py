# -*- coding: utf-8 -*-
from __future__ import unicode_literals

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('forfiles', '0003_auto_20151201_1007'),
    ]

    operations = [
        migrations.AddField(
            model_name='profileimage',
            name='username',
            field=models.CharField(default=0, max_length=30),
            preserve_default=False,
        ),
    ]
