from django.http import HttpResponse
from django.shortcuts import render

def niit(requests):
	return HttpResponse('<h1><body><marquee scrollamount="10">Welcome To Deloitte</marquee></body></h1>') 
	


def home(requests):
	return render(requests,'home.html',{'city':'Hyderabad','company':'Deloitte'})

def home2(requests):
	return render(requests,'home2.html')

def count(request):
	data=request.GET['name'] 
	listw = data.split()
	wordict={}
	for word in listw:
			if word in wordict:
				wordict[word]+=1
			else:
				wordict[word]=1
	return render(request,'count.html',{'dataone':data, 'len': len(listw),'wordict' :wordict.items(),  'sorted_d':sorted((value, key) for (key,value) in wordict.items())})