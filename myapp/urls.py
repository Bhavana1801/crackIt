from django.conf.urls import url
from . import views
urlpatterns = [
    url(r'^main/$', views.main, name='main'),
    # url(r'^registration/$', views.registrationpage, name='registrationpage'),
    url(r'^$', views.main, name='main'),
    url(r'^signup/$', views.signup, name='signup'),
    url(r'^registration/$', views.registration, name='registration'),
    url(r'^profile/$', views.profile, name='profile'),
    url(r'^login/$', views.login, name='login'),
    url(r'^auth_view/$', views.auth_view, name='auth_view'),
]