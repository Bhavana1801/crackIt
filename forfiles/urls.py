from django.conf.urls import url,patterns,include
from django.conf.urls.static import static
from django.conf import settings
from forfiles.views import ProfileImageIndexView,ProfileImageView,ProfileDetailView
from django.contrib import admin
from . import views
admin.autodiscover()
urlpatterns = [
    url(r'^main/$', views.main, name='main'),
    # url(r'^registration/$', views.registrationpage, name='registrationpage'),
    url(r'^$', views.main, name='main'),
    url(r'^signup/$', views.signup, name='signup'),
    url(r'^registration/$', views.registration, name='registration'),
    url(r'^profile/$', views.profile, name='profile'),
<<<<<<< HEAD
    url(r'^sample/$', views.sample, name='sample'),
    url(r'^login/$', views.login, name='login'),
    url(r'^loadProgram/(?P<pgmid>\d+)/$', views.loadProgram,name="loadProgram"),
=======
    url(r'^login/$', views.login, name='login'),
    url(r'^loadProgram/$', views.loadProgram, name='loadProgram'),
>>>>>>> 17fc857c12474914b6016587ff36d81e52aec05f
    url(r'^auth_view/$', views.auth_view, name='auth_view'),
    url(r'^search/$', views.search, name='search'),
    url(r'^addafile/$', ProfileImageIndexView.as_view(), name='add_a_file'),
    url(r'^uploadFile/$',views.upload_file,name='upload_file'),

    url(r'^upload/', ProfileImageView.as_view(), name='profile_image_upload'),
    url(r'^uploaded/(?P<pk>\d+)/$', ProfileDetailView.as_view(), name='profile_image'),

    url(r'^admin/', include(admin.site.urls)),
]+ static(settings.MEDIA_URL, document_root=settings.MEDIA_ROOT)