# Generated by Django 3.2.3 on 2022-10-10 12:07

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('user', '0006_userinfo_reg_date'),
    ]

    operations = [
        migrations.AlterField(
            model_name='userinfo',
            name='reg_date',
            field=models.CharField(default='null', max_length=20, null=True),
        ),
    ]
