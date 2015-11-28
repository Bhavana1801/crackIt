from django.conf.urls import url
from . import views
urlpatterns = [
    url(r'^main/$', views.main, name='main'),
    # url(r'^registration/$', views.registrationpage, name='registrationpage'),
    url(r'^$', views.main, name='main'),
    url(r'^signup/$', views.signup, name='signup'),
    url(r'^registration/$', views.registration, name='registration'),
]