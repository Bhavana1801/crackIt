from django.conf.urls import url
from . import views
urlpatterns = [
    url(r'^main$', views.homepage, name='homepage'),
    url(r'^$', views.homepage, name='homepage'),
    url(r'^login$', views.loginpage, name='loginpage'),
    url(r'^registration$', views.registrationpage, name='registrationpage'),
    url(r'^profile$', views.profile, name='profile'),
    url(r'^uploadFile$', views.uploadFile, name='uploadFile'),
]