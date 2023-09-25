Implementation of The GeoJSON Specification (RFC 7946) using the Jackson Library

In this implementation GeoJson is only an abstraction which can be divided in 4 subtypes: 
Feature, GeometryObject and a collection for each of the mentioned types. 

Geometry Object itself is an abstraction, it is divided by 6 concrete implementations:
LineString, MultiLineString, MultiPoint, MultiPolygon, Point, Polygon. 

Each of the aforementioned Geometry Object types is List of latitude/longitude coordinates which can be used to
represent points, lines and shapes in a map.

Valid GeoJson objects are consumed successfully, while the necessesary exceptions are thrown in the case of an invalid GeoJson.

Unit tests are provided to showcase the functionality of the code.
