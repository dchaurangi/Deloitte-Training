
from django.contrib import admin
from django.urls import path
from .import views
 

urlpatterns = [
    path('admin/', admin.site.urls),
    path('count/',views.count, name='test_count'),
	path('deloitte/', admin.site.urls),
	path('niit/', views.niit),
	#path('', views.home),
	path('', views.home2),
	
]

